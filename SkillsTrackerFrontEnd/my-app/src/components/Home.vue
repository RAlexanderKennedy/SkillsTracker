<template>
  <div>
      <h3>List Of Employees</h3>
      <router-link v-bind:to="{name : 'add'}">Add New Employee?</router-link>
    <div>
      <input class="search" type="text" placeholder="Search By ID" v-model="filter.id">
      <input class="search" type="text" placeholder="Search By Last Name" v-model="filter.lastName">
    </div>
    <div class='employeeCard' v-for='employee in filteredList' v-bind:key='employee.id'>
      Employee ID: {{employee.id}}
      <br>
      Name: {{employee.firstName}} {{employee.lastName}}
      <br>
      Role: {{employee.role}}
      <br>
      Unit: {{employee.businessUnit}}
      <br>

      <router-link v-bind:to="{name: 'modify', params: {id: employee.id}}">View/Edit Details</router-link>
    </div>
  </div>
</template>

<script>
import employeeService from '../services/APIService.js';

export default {
  data() {
    return {
      employeesList : [],
      filter: {
        id: "",
        lastName: ""
      }
    }
  }, 
  created() {
    employeeService.getAllEmployees().then(
      (response) => {
        this.employeesList = response.data;
      }

    );
  },
  computed: {
    filteredList() {
      let filteredEmployees = this.employeesList;
      if (this.filter.id != '') {
        filteredEmployees = filteredEmployees.filter((employee) =>
        employee.id.toLowerCase()
        .includes(this.filter.id.toLowerCase()));
      }
      if(this.filter.lastName != '') {
        filteredEmployees = filteredEmployees.filter((employee) =>
        employee.lastName.toLowerCase()
        .includes(this.filter.lastName.toLowerCase()));
      }
      return filteredEmployees;
    },
}
}
</script>

<style>
.employeeCard {
  padding: 5px;
  margin: 5px;
  border: 1px;
  width: 250px;
  background-color: lavender;
}
</style>