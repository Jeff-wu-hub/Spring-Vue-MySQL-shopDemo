<template>
<!--登陆页面-->
  <div class="main">
  </div>
</template>
<script>
import {mapGetters} from 'vuex'
export default {
  name: "index",
  computed:{
    ...mapGetters([
      'userInfo'
    ])
  },
  methods:{
     login(data){
       this.$store.dispatch('user/logIn',{data})
    }
  },
  mounted() {
    this.login(1)
  }
}
</script>

<style scoped lang="scss">
.main{
  width: 100%;
  height: 100%;
  background-color: #1d3557;
}
</style>
