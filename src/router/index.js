import Vue from 'vue'
import Router from 'vue-router'
import store from "@/store";
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
NProgress.configure({showSpinner: false})
Vue.use(Router)

/* Layout */
import Layout from '@/layout'
import * as path from "path";
export const constantRoutes = [
  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },
  {
    path: '/login',
    component:()=> import('@/views/login/index')
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'table' }
    }]
  },
  {
    path: '/user',
    component: Layout,
    meta: { title: '会员管理', icon: 'user' },
    children: [{
      path: 'userInfo',
      name: 'userInfo',
      component: () => import('@/views/userInfo/userList/index'),
      meta: { title: '用户管理'}
    },]
  },
  {
    path: '/goods',
    component: Layout,
    meta: { title: '商品管理', icon: 'tree' },
    children: [{
      path: 'goodsList',
      name: 'goodsList',
      component: () => import('@/views/goods/goodsList/index'),
      meta: { title: '商品列表'}
    },{
      path: 'goodstype',
      name: 'goodstype',
      component: () => import('@/views/goods/goodstype/index'),
      meta: { title: '商品分类'}
    },{
      path: 'categories',
      name: 'categories',
      component: () => import('@/views/goods/categories/index'),
      meta: { title: '分类参数'}
    },
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]
const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()
router.beforeEach( (to,from,next)=>{
  NProgress.start()
  if(to.path === '/login'){
    next()
    return NProgress.done()
  }else{
    if(!sessionStorage.getItem('login')){
      next({path:'/login'})
      return NProgress.done()
    }
  }
  NProgress.done()
  next()
})
// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
