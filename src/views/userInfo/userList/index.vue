<template>
<Layout>
    <fun-list slot="Header"></fun-list>
    <div class="foot" slot="Footer">
      <el-pagination layout=" prev, pager, next, jumper,total" :total="upForm.total" size="mini" background/></div>
</Layout>
</template>

<script>
import Layout from "@/layout/components/Layout";
import funList from './component/funList';
import bodyForm from './component/bodyForm'
export default {
  name: "index",
  components: {Layout,funList,bodyForm},
  data(){
    return {
      upForm:{
        total:1,//总计

      }
    }
  }
}

</script>

<style scoped lang="scss">
.foot{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background-color: white;
}
</style>
