export default {
  mode: 'spa',
  srcDir: 'src',
  head: {
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      {
        hid: 'description',
        name: 'description',
        content: process.env.npm_package_description || ''
      }
    ],
    link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }]
  },
  loading: { color: '#fff' },
  buildModules: ['@nuxtjs/eslint-module', '@nuxtjs/tailwindcss', '@nuxt/typescript-build'],
  modules: ['@nuxtjs/axios', '@nuxtjs/proxy', '@nuxtjs/pwa', '@nuxtjs/dotenv', '@nuxtjs/tailwindcss', 'nuxt-fontawesome'],
  axios: {},
  proxy: {
    '/api': 'http://localhost:8080'
  },
  build: {
    extend(config, ctx) {}
  },
  fontawesome: {
    imports: [
      {
        set: '@fortawesome/free-solid-svg-icons',
        icons: ['fas']
      }
    ]
  }
}
