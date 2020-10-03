<template>
  <v-card
    class="mx-5 card self-intro"
    v-if="owner"
  >
    <v-card-title >
      <v-avatar size="68" color="grey darken-3">
        <v-img
          class="elevation-6"
          src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortCurly&accessoriesType=Prescription02&hairColor=Black&facialHairType=Blank&clotheType=Hoodie&clotheColor=White&eyeType=Default&eyebrowType=DefaultNatural&mouthType=Default&skinColor=Light"
        ></v-img>
      </v-avatar>
        {{ owner.name }}
      </v-card-title>
      <v-card-text>
        {{ owner.info }}
      </v-card-text>
      <v-row
        align="center"
        justify="left"
      >
        <v-col cols="12">
          <div style="text-align:center;">
            <v-btn icon :href="owner.githubUrl">
              <v-icon class="mx-2">mdi-github</v-icon>
            </v-btn>
            <v-btn icon :href="owner.twitterUrl">
              <v-icon class="mx-2">mdi-twitter</v-icon>
            </v-btn>
          </div>
        </v-col>
      </v-row>
  </v-card>
</template>

<script>
  export default {
    data: () => ({
      owner:null,
    }),
    mounted(){
      this.getOnwerInfo();
    },
    methods:{
      getOnwerInfo(){
        this.owner={ name:"とうふ", info:"一児のパパエンジニア。", githubUrl:"https://www.google.com/?hl=ja", twitterUrl:"https://www.google.com/?hl=ja" }
      }
    },
  }
</script>