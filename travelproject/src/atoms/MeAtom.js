import { atom } from "recoil";


const me = atom({
    key: 'me', // unique ID (with respect to other atoms/selectors)
    default: {
        isLogin: false,
        token: "",
        nickName: "",
        memberId: ""
    }, // default value (aka initial value)
});

