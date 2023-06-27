import axios from "axios";
import port from "../../../public/port";
import { useEffect, useState } from "react";
export default function Page() {
  const [data, changeData] = useState<any[]>([]);
  async function fetchBoards() {
    await axios
      .get(`${port}/board/all?start=0&size=3`)
      .then(function (response) {
        console.log(response.data[0].writer);
        changeData(response.data);
      })
      .catch(function (error) {});
  }
  useEffect(() => {
    fetchBoards();
  }, []);

  return (
    <div
      style={{
        width: "100%",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <h1>커뮤니티</h1>
      {data.map((data, index) => {
        return (
          <div
            key={index}
            style={{ display: "flex", width: "70%", justifyContent: "center" }}
          >
            <div style={{ width: "10%" }}>{data?.boardSeq}</div>
            <div style={{ width: "20%" }}>{data?.writer}</div>
            <div style={{ width: "30%" }}>{data?.title}</div>
            <div style={{ width: "20%" }}>{data?.viewCnt}</div>
            <div style={{ width: "20%" }}>{data?.createTime}</div>
          </div>
        );
      })}
    </div>
  );
}
