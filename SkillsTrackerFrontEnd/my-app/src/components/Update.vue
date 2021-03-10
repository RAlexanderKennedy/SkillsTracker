<template>
  <div>
      <h3>Edit Employee Data</h3>

      <button v-on:click.prevent='deleteEmployee'>Remove?</button>

      <form v-on:submit.prevent='updateEmployee'>
          ID: {{currentEmployee.id}}
          First Name: <input type='text' v-model='currentEmployee.firstName'/> <br>
          Last Name: <input type='text' v-model='currentEmployee.lastName' /> <br>
          Role: <input type='text' v-model='currentEmployee.role' /> <br>    
          Business Unit: <input type='text' v-model='currentEmployee.businessUnit' /> <br> 
          Contact Email: <input type='text' v-model='currentEmployee.contactEmail' /> <br>
          Company Email: <input type='text' v-model='currentEmployee.companyEmail' /> <br>
          Birth Date: <input type='date' v-model='currentEmployee.birthDate' /> <br>
          Hired Date: <input type='date' v-model='currentEmployee.hiredDate' /> <br>
          Assigned To: <input type='text' v-model='currentEmployee.assignedTo' /> <br>
          Street Address: <input type='text' v-model='currentEmployee.address.street' /> <br>  
          Suite: <input type='text' v-model='currentEmployee.address.suite' /> <br>
          City: <input type='text' v-model='currentEmployee.address.city' /> <br>
          Region: <input type='text' v-model='currentEmployee.address.region' /> <br>
          Postal: <input type='text' v-model='currentEmployee.address.postal' /> <br>  
          Country: <input type='text' v-model='currentEmployee.address.country' /> <br>
          <button>Save</button>
      </form>
      <router-link v-bind:to="{name: 'skills', params: {id: currentEmployee.id}}">View Skills</router-link>
  </div>
</template>

<script>
import employeeService from '../services/APIService';
export default {
  created() {
    const idPassed = this.$route.params.id;
    employeeService.getEmployeeById(idPassed).then(
      (response) => {
        this.currentEmployee = response.data;
      }
    )
  },
  data() {
    return {
      currentEmployee : {}
    }
  }, 
  methods : {
    updateEmployee() {
       employeeService.updateEmployee(this.currentEmployee).then(
         () => {
           window.alert('Employee info updated.');
           this.$router.push({name : 'home'});
         }

       ).catch(
         window.alert("Sorry, there was an error updating the employee. Please confirm the information entered is correct and try again.")
       )
    },
    deleteEmployee() {
      const idPassed = this.$route.params.id;
      employeeService.deleteEmployee(idPassed).then(
        () => {
          window.alert('Employee Removed');
          this.$router.push({name: 'home'});
        }

      ).catch(
        window.alert("Sorry, there was an error deleting the employee.")
      );
    }
  }
}
</script>

<style>

</style>