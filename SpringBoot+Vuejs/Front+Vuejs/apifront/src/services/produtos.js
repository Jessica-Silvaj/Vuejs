import { http } from './config';

export default {

    //Caminho principal
    getAll: () => {
        return http.get('/produtos');
    },

    create(produto) {
        return http.post("/produto", produto);
    },

    atualizar: (id, produto) => {
        return http.put(`/produto/${id}`, produto);
    },

    apagar: (id) => {
        return http.delete(`/produto/${id}`)
    },

    excluir() {
        return http.delete(`/produto`)
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