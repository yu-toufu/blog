export default {
    methods: {
        getDisplayDate(date){
            return new Date(date).toLocaleString('ja-JP');
        }
    }
  }