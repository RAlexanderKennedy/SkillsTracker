<template>
  <div>
      <h3>List Of Employees</h3>
      <router-link v-bind:to="{name : 'add'}">Add New Employee?</router-link>

    <div class='employeeCard' v-for='employee in employeesList' v-bind:key='employee.id'>
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
      employeesList : []
    }
  }, 
  created() {
    employeeService.getAllEmployees().then(
      (response) => {
        this.employeesList = response.data;
      }

    );
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