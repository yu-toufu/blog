<template>
    <div>
        <v-breadcrumbs :items="items" large>
            <template v-slot:divider>
                <v-icon>mdi-chevron-right</v-icon>
            </template>
            
        </v-breadcrumbs>
    </div>
</template>

<script>

export default {
  name: 'Breadcrubs',
  components: {
  },
  data: () => ({
    items:[
      { text: 'Home', disabled: true},
    ],
  }),
  methods:{
    changeBreadcrumbs(breadcrumbs){
        this.items=breadcrumbs
    },
    initBreadcrumbs(){
        this.items=[{ text: 'Home', disabled: true },]
    }
  }
};
</script>
