import { http } from './config';

export default {

    //Caminho principal
    getAll: () => {
        return http.get('/produtos');
    },

    salvar: (produto) => {

        return http.post('/produto', produto);
    },

    atualizar: (id, produto) => {
        return http.put(`/produto/${id}`, produto);
    },

    apagar: (id) => {
        return http.delete(`/produto/${id}`)
    },

    Buscar: (nome) => {
        return http.get(`/produto/${nome}`)
    },


    ListCateg: () => {
        return http.get('/Categorias');

    },

    ListStatus: () => {
        return http.get('/Status');
    },


}