import React, { useState } from 'react';
import axios from 'axios';

axios.defaults.withCredentials = true;

function App() {
  const [loginData, setLoginData] = useState({
    email: 'jaeeun@test.com',
    password: '123456789',
    type: 'MEMBER',
  });

  const handleLogin = async () => {
    try {
      // 로그인 데이터를 서버로 보내기
      const response = await axios.post('http://localhost:8080/signin', loginData);

      // 서버 응답 처리
      console.log(response.data); // 원하는 응답 처리 방법으로 수정
    } catch (error) {
      console.error('로그인 실패:', error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setLoginData({
      ...loginData,
      [name]: value,
    });
  };

  return (
    <>
    <div>
      <h3>로그인</h3>
      <span>이메일 </span>
      <input
        type="text"
        placeholder="이메일"
        name="email"
        value={loginData.email}
        onChange={handleInputChange}
      />
      <br/>
      <span>비밀번호 </span>
      <input
        type="password"
        placeholder="비밀번호"
        name="password"
        value={loginData.password}
        onChange={handleInputChange}
      />
      <br/>
      <span>타입</span>
      <input
        type="text"
        placeholder="타입"
        name="type"
        value={loginData.type}
        onChange={handleInputChange}
      />
      <br/>
      <button onClick={handleLogin}>로그인</button>
    </div>
    <div>
      <h3>authorization 확인</h3>
    </div>
    </>
  );
}

export default App;
