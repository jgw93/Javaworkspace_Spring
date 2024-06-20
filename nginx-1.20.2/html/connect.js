const callServer = async (url) =>{
//   console.log("call server 1...")
  // accessToken을 localStorage에서 취득
  const accessToken = localStorage.getItem("accessToken")
  //accessToken이 있는지 없는지 확인
  // accessToken의 데이터가 있으면 true
  // accessToken의 데이터가 없으면 false
  if(!accessToken){
      throw 'Cannot Find Access Token'
  }
  //accessToken을 해더에 설정
  const authHeader = {"authorization":`Bearer ${accessToken}`}
  try{
      //실행하고싶은 AJAX코드를 실행
      const res = await axios.get(url, {headers:authHeader})
      //에러가 없으면 데이터를 반환
      return res.data
  }catch(err){
      //accessToken이 만료시 refreshToken을 실행
      if(err.response.data.msg === 'Expired Token'){
          console.log("Refresh Your Token")
          try{
              //비동기 처리로 refreshToken 실행을 위한 메서드를 실행
              await callRefresh()
              console.log("new tokens....saved..")
              // 처음 실행되었던 자기자신을 실행
              return callServer()
          }catch(refreshErr){
              throw refreshErr.response.data.msg
          }
      }
  }
}
const register = async (url,formData) =>{
    //   console.log("call server 1...")
      // accessToken을 localStorage에서 취득
      const accessToken = localStorage.getItem("accessToken")
      //accessToken이 있는지 없는지 확인
      // accessToken의 데이터가 있으면 true
      // accessToken의 데이터가 없으면 false
      if(!accessToken){
          throw 'Cannot Find Access Token'
      }
      //accessToken을 해더에 설정
      const authHeader = {"authorization":`Bearer ${accessToken}`}
      try{
          //실행하고싶은 AJAX코드를 실행
          const res = await axios.post(url, formData ,{headers:authHeader})
          //에러가 없으면 데이터를 반환
          return res.data
      }catch(err){
          //accessToken이 만료시 refreshToken을 실행
          if(err.response.data.msg === 'Expired Token'){
              console.log("Refresh Your Token")
              try{
                  //비동기 처리로 refreshToken 실행을 위한 메서드를 실행
                  await callRefresh()
                  console.log("new tokens....saved..")
                  // 처음 실행되었던 자기자신을 실행
                  return callServer()
              }catch(refreshErr){
                  throw refreshErr.response.data.msg
              }
          }
      }
    }

    const modify = async (url,formData) =>{
        //   console.log("call server 1...")
          // accessToken을 localStorage에서 취득
          const accessToken = localStorage.getItem("accessToken")
          //accessToken이 있는지 없는지 확인
          // accessToken의 데이터가 있으면 true
          // accessToken의 데이터가 없으면 false
          if(!accessToken){
              throw 'Cannot Find Access Token'
          }
          //accessToken을 해더에 설정
          const authHeader = {"authorization":`Bearer ${accessToken}`}
          try{
              //실행하고싶은 AJAX코드를 실행
              const res = await axios.put(url, formData ,{headers:authHeader})
              //에러가 없으면 데이터를 반환
              return res.data
          }catch(err){
              //accessToken이 만료시 refreshToken을 실행
              if(err.response.data.msg === 'Expired Token'){
                  console.log("Refresh Your Token")
                  try{
                      //비동기 처리로 refreshToken 실행을 위한 메서드를 실행
                      await callRefresh()
                      console.log("new tokens....saved..")
                      // 처음 실행되었던 자기자신을 실행
                      return callServer()
                  }catch(refreshErr){
                      throw refreshErr.response.data.msg
                  }
              }
          }
        }

const remove = async (url) =>{
      // accessToken을 localStorage에서 취득
      const accessToken = localStorage.getItem("accessToken")
      //accessToken이 있는지 없는지 확인
      // accessToken의 데이터가 있으면 true
      // accessToken의 데이터가 없으면 false
      if(!accessToken){
          throw 'Cannot Find Access Token'
      }
      //accessToken을 해더에 설정
      const authHeader = {"authorization":`Bearer ${accessToken}`}
      try{
          //실행하고싶은 AJAX코드를 실행
          const res = await axios.delete(url, {headers:authHeader})
          //에러가 없으면 데이터를 반환
          return res.data
      }catch(err){
          //accessToken이 만료시 refreshToken을 실행
          if(err.response.data.msg === 'Expired Token'){
              console.log("Refresh Your Token")
              try{
                  //비동기 처리로 refreshToken 실행을 위한 메서드를 실행
                  await callRefresh()
                  console.log("new tokens....saved..")
                  // 처음 실행되었던 자기자신을 실행
                  return callServer()
              }catch(refreshErr){
                  throw refreshErr.response.data.msg
              }
          }
      }
    }
const callRefresh = async () =>{
  //accessToken, refreshToken 취득
  const accessToken = localStorage.getItem("accessToken")
  const refreshToken = localStorage.getItem("refreshToken")
  const tokens = {accessToken, refreshToken}
  // Ajax로 refreshToken을 실행
  const res = await axios.post("http://localhost:8080/refreshToken",tokens)
  localStorage.setItem("accessToken",res.data.accessToken)
  localStorage.setItem("refreshToken",res.data.refreshToken)
}

const getLink = (formObj) => {
    let link = '?' 
    link += "page="+formObj.page.value;
    link += "&size="+formObj.size.value;
    // if(formObj.type.value != null){
    //     link += "&type="+formObj.type;
    // }
    if(formObj.keyword.value != null){
        link += "&keyword="+ formObj.keyword.value;
    }
    if(formObj.from.value != null && formObj.to.value != null){
        link += "&from="+ formObj.from.value;
        link += "&to="+ formObj.to.value;
    }
    return link;
}
function dateFormat(date){
    
}

