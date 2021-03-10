<template>
  <div>
      <h3>Edit Skill Data</h3>

      <button v-on:click.prevent='deleteSkill'>Remove?</button>

      <form v-on:submit.prevent='updateSkill'>
          ID: {{currentSkill.skillId}} <br>
          Field: <input type='text' v-model='currentField.name'/> <br>
          Field ID: <input type='text' v-model='currentField.skillFieldId' /> <br>
          Type: <input type='text' v-model='currentField.type' /> <br>
          Experience (In Months): <input type='text' v-model='currentSkill.experience' /> <br>   
          Summary: <input type='text' v-model='currentSkill.summary' /> <br>
          <button>Save</button>
      </form>
  </div>
</template>

<script>
import employeeService from '../services/APIService';
export default {
  created() {
    const idPassed = this.$route.params.id;
    const skillIdPassed = this.$route.params.skillId;
    employeeService.findSkill(skillIdPassed, idPassed).then(
      (response) => {
        this.currentSkill = response.data;
        this.currentField = this.currentSkill.field;
      }
    )
  },
  data() {
    return {
      currentSkill : {},
      currentField : {}
    }
  }, 
  methods : {
    updateSkill() {
        const idPassed = this.$route.params.id;
       this.currentSkill.field = this.currentField
       employeeService.editEmployeeSkill(this.currentSkill, idPassed).then(
         () => {
           window.alert('Skill info updated.');
           this.$router.push({name : 'home'});
         }

       )
    },
    deleteSkill() {
      const idPassed = this.$route.params.id;
      const skillIdPassed = this.$route.params.skillId;
      employeeService.deleteSkill(skillIdPassed, idPassed).then(
        () => {
          window.alert('Skill Removed');
          this.$router.push({name: 'home'});
        }

      );
    }
  }
}
</script>

<style>

</style>