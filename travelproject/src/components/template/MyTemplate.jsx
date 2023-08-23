import { Outlet } from "react-router"
import MyHeader from "./MyHeader"
import MyFooter from "./MyFooter"


const MyTemplate = () => {
    return <div>
        <MyHeader></MyHeader>
        <Outlet></Outlet>
        <MyFooter></MyFooter>
    </div>


}

export default MyTemplate