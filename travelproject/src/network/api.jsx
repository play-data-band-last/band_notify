import axios from "axios"

export const apiNoToken = async (url, method, bodies, headers) => {
    const body = await axios({
        url, method, data: bodies,
        headers: { headers }
    }
    )
    return body.data

}

export const apiWithToken = async (url, method, bodies, headers) => {
    const body = await axios(
        url, method, bodies, {
        header: {
            headers
        }
    }
    )
    return body
}





