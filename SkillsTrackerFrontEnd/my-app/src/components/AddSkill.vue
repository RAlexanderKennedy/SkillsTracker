<template>
  <div>
      <h3>Add A Skill</h3>
      <form v-on:submit.prevent = 'addSkill'>
          ID: <input type='text' v-model='newSkill.skillId'/> <br>
          Field: <input type='text' v-model='newField.name'/> <br>
          Field ID: <input type='text' v-model='newField.skillFieldId' /> <br>
          Type: <input type='text' v-model='newField.type' /> <br>
          Experience (In Months): <input type='text' v-model='newSkill.experience' /> <br>   
          Summary: <input type='text' v-model='newSkill.summary' /> <br>
          <button>Save</button>
      </form>
  </div>
</template>

<script>
import employeeService from '../services/APIService.js';

export default {
  data () {
    return {
      newSkill : {},
      newField : {}
    }
  },
  methods: {
    addSkill() {
      this.newSkill.field = this.newField  
      employeeService.addSkill(this.newSkill, this.$route.params.id).then(
        () => {
          window.alert('Skill Added');
          this.newSkill = {};
          this.$router.push({name: 'home'});
        }

      );
    }
  }
}
</script>

<style>

</style>