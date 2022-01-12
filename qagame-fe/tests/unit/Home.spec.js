import { mount } from '@vue/test-utils'
import Home from '@/components/Home.vue'

describe('Home.vue', () => {

    let name = 'Juan';
    localStorage.setItem('username', name);
    let getItem = jest.spyOn(Storage.prototype, 'getItem');
    let wrapper = mount(Home);

    it('Comportamiento inesperado de Home con el localStorage', () => {
        expect(wrapper.text()).toMatch('¡Bienvenido ' + name + '!');
    });

    it('localStorage no ha sido consultado por el componente Home', () => {
        expect(getItem).toHaveBeenCalled();
    })

})