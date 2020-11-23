// @ts-nocheck

const myVue = new Vue({

    data: {
        greeting: 'Happy Monday!',
        firstName: 'Fred',
        lastName: 'Cat',
        size: 'large',
        students: [
            'Ryan',
            'Stephanie',
            'Megan',
            'Zach',
            'Kurt'
        ]
    }

});

myVue.$mount('#myApp');