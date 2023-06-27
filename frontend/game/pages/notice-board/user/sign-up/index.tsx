export default function Page() {
  return (
    <div
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      <h1>회원가입</h1>
      email : <input />
      password : <input />
      name : <input />
      nickname : <input />
      <div>
        <button>회원가입</button>
        <button>뒤로</button>
      </div>
    </div>
  );
}
