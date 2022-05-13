<template>
  <v-form>
        <br>
          <h2>Form</h2>
        <br>
      <v-text-field v-if="id" v-model="id" label="Id"> </v-text-field>
      <v-text-field v-model="name" label="Name"> </v-text-field>
      <v-text-field v-model="email" label="Email"> </v-text-field>
      <v-text-field v-model="password" label="Password"> </v-text-field>
      <v-btn @click="submit({ id, name, email, password })"> {{
        id ? 'Edit': 'Submit'
        }} </v-btn>
  </v-form>
</template>

<script>
export default {
  computed:{
    id: { 
      get(){
        return this.$store.state.user.id;
      },
      set(value){
        this.$store.commit("user/storeId", value)
      },
    },
    name:{
      get(){
        return this.$store.state.user.name;
      },
      set(value){
        this.$store.commit("user/storeName", value)
      },
    },
    email:{
      get(){
        return this.$store.state.user.email;
      },
      set(value){
        this.$store.commit("user/storeEmail", value)
      },
    },
    password:{
      get(){
        return this.$store.state.user.password;
      },
      set(value){
        this.$store.commit("user/storePassword", value)
      },
    },
  },
  methods:{
    async submit(user){
      if(user.id){
        await this.$axios.put("http://localhost:8080/users/" + user.id, user);
      }
      else{
        await this.$axios.post("http://localhost:8080/users/" + user);
      }
      await this.restForm({ id: 0, name: "", email: "", password: "" });
        this.$store.commit(
                  "users/storeData",
                  (await this.$axios.get("http://localhost:8080/users/")).data
              );
    },
    restForm(user){
      this.$store.commit("user/storeId", user.id);
      this.$store.commit("user/storeName", user.name);
      this.$store.commit("user/storeEmail", user.email);
      this.$store.commit("user/storePassword", user.password);
    },
  },
};
</script>

<style>

</style>