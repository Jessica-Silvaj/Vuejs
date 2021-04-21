import  Vue from 'vue';
import Router from 'vue-router';

import Home from './pages/Home'
import Adicionar from './pages/AdicionarProd';
import Excluir from './pages/Excluir'
import Editar from './pages/Editar'

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes:[
        {
            path:"/",
            component: Home
        },
        {
            path: '/AdicionarProd',
            component: Adicionar
        },

        {
            path: '/Excluir',
            component: Excluir
        },

        {
            path: '/Editar',
            component:Editar
        },



    ]

})