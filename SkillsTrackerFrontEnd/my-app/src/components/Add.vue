<template>
  <div>
      <h3>Add an Employee</h3>
      <form v-on:submit.prevent = 'addEmployee'>
          First Name: <input type='text' v-model='newEmployee.firstName'/> <br>
          Last Name: <input type='text' v-model='newEmployee.lastName' /> <br>
          Role: <input type='text' v-model='newEmployee.role' /> <br>    
          Business Unit: <input type='text' v-model='newEmployee.businessUnit' /> <br> 
          ID: <input type='text' v-model='newEmployee.id' /> <br>
          Contact Email: <input type='text' v-model='newEmployee.contactEmail' /> <br>
          Company Email: <input type='text' v-model='newEmployee.companyEmail' /> <br>
          Birth Date: <input type='date' v-model='newEmployee.birthDate' /> <br>
          Hired Date: <input type='date' v-model='newEmployee.hiredDate' /> <br>
          Assigned To: <input type='text' v-model='newEmployee.assignedTo' /> <br>
          Street Address: <input type='text' v-model='newAddress.street' /> <br>  
          Suite: <input type='text' v-model='newAddress.suite' /> <br>
          City: <input type='text' v-model='newAddress.city' /> <br>
          Region: <input type='text' v-model='newAddress.region' /> <br>
          Postal: <input type='text' v-model='newAddress.postal' /> <br>  
          Country: <input type='text' v-model='newAddress.country' /> <br>
          <button>Save</button>
      </form>
  </div>
</template>

<script>
import employeeService from '../services/APIService.js';

export default {
  data () {
    return {
      newEmployee : {},
      newAddress : {}
    }
  },
  methods: {
    addEmployee() {
      this.newEmployee.address = this.newAddress  
      employeeService.addEmployee(this.newEmployee).then(
        () => {
          window.alert('Employee Added');
          this.newEmployee = {};
          this.$router.push({name: 'home'});
        }

      );
    }
  }
}
</script>

<style>

</style>