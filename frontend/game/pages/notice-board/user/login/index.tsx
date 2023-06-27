export default function Page() {
  return (
    <div
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      <h1>로그인</h1>
      id : <input />
      password : <input />
      <div>
        <button>로그인</button>
        <button>회원가입</button>
      </div>
    </div>
  );
}
