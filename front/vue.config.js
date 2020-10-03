module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  // 開発用CORS対策。
  devServer: {
    proxy: 'http://localhost:8080'
  }
}