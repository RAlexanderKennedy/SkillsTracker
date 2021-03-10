<template>
  <div>
      <h3> Skills</h3>
      <router-link v-bind:to="{name : 'addSkill', params: {id: this.$route.params.id}}">Add New Skill?</router-link>

    <div class='skillCard' v-for='skill in skills' v-bind:key='skill.skillId'>
      
      Field: {{skill.field.name}}
      <br>
      Experience: {{skill.experience}}

      <router-link v-bind:to="{name: 'modifySkill', params: {id: skill.id},params: {skillId: skill.skillId}}">View/Edit Details</router-link>
    </div>
  </div>
</template>

<script>
import employeeService from '../services/APIService.js';

export default {
  data() {
    return {
      skills : []
    }
  }, 
  created() {
    const idPassed = this.$route.params.id;
    employeeService.getEmployeeSkills(idPassed).then(
      (response) => {
        this.skills = response.data;
      }
    )
  }
  
}
</script>

<style>
.skillCard {
  padding: 5px;
  margin: 5px;
  border: 1px;
  width: 250px;
  background-color: lavender;
}
</style>