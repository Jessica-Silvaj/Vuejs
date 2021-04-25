<template>
  <div>
    <!-- Modal novo -->
    <div
      class="modal show fade"
      id="exampleModal"
      tabindex="-1"
      role="dialog"
      style="display: block"
      v-if="visible"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">
              Editar Produto
            </h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
              @click="visible = false"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>

              <label class="Titulo">ID do Produto: </label>
              <input type="text" v-model="produto.id" />

              <label class="Titulo">Nome do produto </label>
              <input type="text" v-model="produto.nome" />

              <label class="Titulo">Código </label>
              <input type="text" v-model="produto.codigo" />

              <label class="Titulo">Status </label>
              <div class="combobox">
                <ejs-combobox
                  id="combobox"
                  :dataSource="status"
                  placeholder="Selecione o status"
                  v-model="produto.status"
                ></ejs-combobox>
              </div>
              

              <label class="Titulo">Categorias</label>
              <div class="combobox">
                <ejs-combobox
                  id="combobox"
                  :dataSource="categoria"
                  placeholder="Selecione a categoria"
                  v-model="produto.categoria"
                ></ejs-combobox>
              </div>

              <label class="Titulo">Preço </label>
              <input
                type="number"
                step="0.01"
                min="0.01"
                v-model="produto.preco"
              />
            </form>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
              @click="visible = false"
            >
              Fecha
            </button>
            <button @click="EditarInfo" type="button" class="btn btn-primary">
              Editar Produtos
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="modal-backdrop fade show" v-if="visible"></div>
  </div>
</template>

<script>
import Vue from "vue";
import { ComboBoxPlugin } from "@syncfusion/ej2-vue-dropdowns";
Vue.use(ComboBoxPlugin);
import Produtos from "../services/produtos";

export default {
  data() {
    return {
      categoria: [],
      status: [],
      visible: false,
      produto: {
        id: null,
        nome: "",
        categoria: "",
        codigo: "",
        status: "",
        preco: "",
      },
    };
  },

  mounted() {
    Produtos.ListCateg().then((response) => {
      this.categoria = response.data;
    });

    Produtos.ListStatus().then((response) => {
      this.status = response.data;
    });

    this.listar();
  },
  methods: {
    listar() {
      Produtos.getAll().then((response) => {
        this.Produtos = response.data;
      });
    },

    EditarInfo() {
      if (!this.produto.id) {
        Produtos.create(this.produto)
          .then((response) => {
            this.produto = response.data;
            this.listar();
            alert("Salvo com sucesso!");
          })
          .catch((e) => {
            this.errors = e.response.data.errors;
          });
      } else {
        Produtos.atualizar(this.id, this.produto)
          .then((response) => {
            this.produto = response.data;
            this.listar();
            alert("Atualizado com sucesso!");
            this.errors = [];
          })
          .catch((e) => {
            this.errors = e.response.data.errors;
            alert("Preenchar todos os dados")
          });
      }

      window.location.reload()
    }, 
  },
      editar(produto) {
      this.produto = produto;
    },
  created() {
    this.$root.$on("open-modal-editar", () => {
      this.visible = true;
    });
  },
};
</script>


<style scoped>
@import "../../node_modules/@syncfusion/ej2-base/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-inputs/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-vue-dropdowns/styles/material.css";

.combobox {
  padding-top: -20px;
  flex-direction: column;
  margin-left: 2px;
  width: 460px;
  border-radius: 10px;
  border: none;
}

h5 {
  margin: auto;
  font-weight: bold;
  font-size: 16pt;
}
.close {
  margin: 15px;
  display: flex;
  align-items: center;
  cursor: pointer;
  border: 0;
  border-radius: 15px;
}
.Titulo {
  margin-left: 15px;
  margin-right: 5px;
  font-weight: bold;
  font-size: 20px;
  display: flex;
  flex-direction: column;
}
input {
  height: 35px;
  flex-direction: column;
  margin-left: 2px;
  width: 460px;
  border-radius: 5px;
  border: none;

  border: 1px solid #000000;
}

select {
  border: 1px solid #000000;
}

.categ {
  margin-left: 2px;
  height: 20px;
  flex-direction: flex;
  margin-left: 2px;
  border-radius: 5px;
  border: none;
}
</style>