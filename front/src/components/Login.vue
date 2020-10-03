<template>
    <v-card width="400px" class="mx-auto mt-5">
        <v-card-title>Login</v-card-title>
        <v-card-text>
        <v-form>
            <v-text-field prepend-icon="mdi-account-circle" label="User" />
            <v-text-field 
                v-bind:type="showPassword ? 'text' : 'password'" 
                prepend-icon="mdi-lock" label="Password"  append-icon="mdi-eye-off"
                @click:append="showPassword = !showPassword" 
                />
            <v-card-actions>
            <v-btn text color="deep-purple accent-4">Login</v-btn>
            </v-card-actions>
        </v-form>
        </v-card-text>
    </v-card>
</template>

<script>
export default {
    name: 'Login',
    data: () => ({
        showPassword : false
    })
}
</script>
