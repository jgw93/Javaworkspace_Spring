async function checkId(memberId){
    console.log(memberId)
    //Ajax Get 처리를 시작하는 코드, 파라미터로 아이디를 전송
    const response = await axios.get("/check",{params:{memberId}})
    //아이디 존재여부를 화면으로 전송
    return response.data
}