import { mount, flushPromises } from '@vue/test-utils'
import App from '@/App.vue'
import router from '@/router.js'

describe('App.vue', () => {

    const push = jest.spyOn(router, 'push');

    let wrapper = mount(App, {
        global: {
            plugins: [router]
        }
    });

    it('El componente App no inicia en el componente hijo adecuado', async() => {

        await router.isReady()
        await flushPromises()

        expect(wrapper.vm.is_auth).toEqual(false);
        expect(wrapper.findComponent({ name: 'LogIn' }).exists()).toBe(true)
        expect(push).toHaveBeenLastCalledWith({ name: "logIn" });

    });

    it('El enrutamiento al componente signUp no se ejecuta adecuadamente', async() => {

        router.push('/user/signUp')
        await flushPromises()

        expect(wrapper.vm.is_auth).toEqual(false);
        expect(wrapper.findComponent({ name: 'SignUp' }).exists()).toBe(true)
        expect(push).toHaveBeenLastCalledWith('/user/signUp');

    });

    it('El botón logIn no funciona correctamente', async() => {

        await wrapper.find('#app > div.header > nav > button:nth-child(1)').trigger('click')
        await flushPromises()

        expect(wrapper.findComponent({ name: 'LogIn' }).exists()).toBe(true)
        expect(push).toHaveBeenLastCalledWith({ name: "logIn" });

    });

    it('El botón signUp no funciona correctamente', async() => {

        await wrapper.find('#app > div.header > nav > button:nth-child(2)').trigger('click')
        await flushPromises()

        expect(wrapper.findComponent({ name: 'SignUp' }).exists()).toBe(true)
        expect(push).toHaveBeenLastCalledWith({ name: "signUp" });

    });
})