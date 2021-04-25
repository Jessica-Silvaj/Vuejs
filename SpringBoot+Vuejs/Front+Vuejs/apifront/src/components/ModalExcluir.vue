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
            <h5 class="modal-title" id="exampleModalLabel">Excluir Produto</h5>
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
              <label class="Titulo"> ID do produto </label>
              <input type="text" v-model="produto.id" />
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
            <button
              @click.prevent="remover()"
              type="button"
              class="btn btn-primary"
            >
              Excluir Produto
            </button>
          </div>
        </div>
      </div>
    </div>

    <div class="modal-backdrop fade show" v-if="visible"></div>
  </div>
</template>

<script>
import Produtos from "../services/produtos";

export default {
  data() {
    return {
      categoria: [],
      status: [],
      visible: false,
      produto: {
        Id: "",
        nome: "",
        preco: "",
        codigo: "",
        descricao: "",
        categoria: "",
        status: "",
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
  },

  methods: {
    salvar() {
      Produtos.salvar(this.produto).then((response) => {
        this.produto = response.data;
      });
    },

    remover() {
      if (confirm("Deseja excluir o produto?")) {
        Produtos.apagar(this.produto.id)
          .then((response) => {
            this.produto = response.data;
            this.errors = [];
          })
          .catch((e) => {
            this.errors = e.response.data.errors;
          });
      }
      window.location.reload();
    },
  },

  created() {
    this.$root.$on("open-modal-excluir", () => {
      this.visible = true;
    });
  },
};
</script>

<style scoped>
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
</style>