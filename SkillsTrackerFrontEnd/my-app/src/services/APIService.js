import axios from 'axios';

 const http = axios.create({
   baseURL: "http://localhost:8080"
 });

 export default {
     getAllEmployees() {
         return http.get('/employees');
     },

     addEmployee(employee) {
         return http.post('/employees', employee);
     },

     getEmployeeById(id) {
         return http.get(`/employees/${id}`);
     },

     updateEmployee(employee) {
         return http.put(`/employees/${employee.id}`, employee);
     },

     deleteEmployee(id) {
         return http.delete(`/employees/${id}`);
     },

     getEmployeeSkills(employeeId){
         return http.get(`/employees/${employeeId}/skills`);
     },

     addSkill(skill, employeeId){
         return http.post(`/employees/${employeeId}/skills`, skill);
     },

     findSkill(skillId, employeeId){
         return http.get(`/employees/${employeeId}/skills/${skillId}`);
     },

     editEmployeeSkill(skill, employeeId){
         return http.put(`/employees/${employeeId}/skills/${skill.skillId}`, skill);
     },

     deleteSkill(skillId, employeeId){
         return http.delete(`/employees/${employeeId}/skills/${skillId}`);
     }
 }