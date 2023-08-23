import { Route, Routes } from "react-router"
import Feed from "../feed/Feed"
import FeedPost from "../feed/FeddPost"


const MyRoute = () => {
    return <>
        <Routes>
            <Route path="/feed" element={<Feed />} />
            <Route path="worldcup" />
            <Route path="/main" />
            <Route path="feedPost" element={<FeedPost />} />
        </Routes>
    </>
}

export default MyRoute