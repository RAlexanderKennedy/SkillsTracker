import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../components/Home.vue';
import Add from '../components/Add.vue';
import Update from '../components/Update.vue';
import SkillsList from '../components/SkillsList.vue';
import AddSkill from '../components/AddSkill.vue';
import ModifySkill from '../components/UpdateSkill.vue'

Vue.use(VueRouter)

const routes = [
    {path: '/', name: 'home', component: Home},
    {path: '/add', name: 'add', component: Add},
    {path: '/modify/:id', name: 'modify', component: Update},
    {path: '/skills:id', name: 'skills', component: SkillsList},
    {path: 'add/skills:id', name: 'addSkill', component: AddSkill},
    {path: 'modify:id/skills:skillId/', name: 'modifySkill', component: ModifySkill}
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
  
  export default router