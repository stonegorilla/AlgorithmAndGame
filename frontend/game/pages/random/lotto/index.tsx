"use client";
import Link from "next/link";
import axios from "axios";
import React, { useState } from "react";
export default function Page() {
  const [startNum, setStartNum] = useState("");
  const [endNum, setEndNum] = useState("");
  const [count, setCount] = useState("");
  const [isDistinct, setIsDistinct] = useState(true);
  const [arr, setArr] = useState([]);
  const [startNumRed, setStartNumRed] = useState("");
  const [endNumRed, setEndNumRed] = useState("");
  const [countRed, setCountRed] = useState("");
  function makeResult() {
    if (startNumRed != "" && endNumRed != "" && countRed != "") {
      alert("올바른 값을 입력해주세요");
      return;
    }
    axios
      .get(
        `http://localhost:8080/random/lotto?start=${startNum}&end=${endNum}&count=${count}&isDistinct=${isDistinct}`
      )
      .then((response) => {
        setArr(response.data.data);
      });
  }
  return (
    <div
      style={{
        padding: "30px",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        width: "100%",
      }}
    >
      <h1>로또번호 추출기</h1>
      {/* 숫자범위, 개수,중복여부 */}
      시작번호 :{" "}
      <input
        value={startNum}
        onChange={(e) => {
          const newValue = e.target.value;
          if (!newValue.match(/^-?\d+$/)) {
            setStartNumRed("수를 입력해 주세요");
          } else if (Number(newValue) < -100000) {
            setStartNumRed("더 큰 수를 입력해 주세요");
          } else if (Number(newValue) > 100000) {
            setStartNumRed("더 작은 수를 입력해 주세요");
          } else if (
            endNum.match(/^-?\d+$/) &&
            Number(newValue) > Number(endNum)
          ) {
            setStartNumRed("시작번호는 끝번호보다 클 수 없습니다.");
          } else {
            setStartNumRed("");
          }
          setStartNum(newValue);
        }}
      />
      <div style={{ color: "red" }}>{startNumRed}</div>
      끝번호 :{" "}
      <input
        value={endNum}
        onChange={(e) => {
          const newValue = e.target.value;
          if (!newValue.match(/^-?\d+$/)) {
            setEndNumRed("수를 입력해 주세요");
          } else if (Number(newValue) < -100000) {
            setEndNumRed("더 큰 수를 입력해 주세요");
          } else if (Number(newValue) > 100000) {
            setEndNumRed("더 작은 수를 입력해 주세요");
          } else if (
            startNum.match(/^-?\d+$/) &&
            Number(newValue) < Number(startNum)
          ) {
            setEndNumRed("끝번호는 시작번호보다 작을 수 없습니다.");
          } else {
            setEndNumRed("");
          }
          setEndNum(newValue);
        }}
      />
      <div style={{ color: "red" }}>{endNumRed}</div>
      개수 :{" "}
      <input
        value={count}
        onChange={(e) => {
          const newValue = e.target.value;
          if (!newValue.match(/^-?\d+$/)) {
            setCountRed("수를 입력해 주세요");
          } else if (Number(newValue) < 1) {
            setCountRed("개수는 최소 1개 입니다.");
          } else if (Number(newValue) > 10000) {
            setCountRed("개수는 최대 10000개 입니다.");
          } else if (
            isDistinct &&
            startNum.match(/^-?\d+$/) &&
            endNum.match(/^-?\d+$/) &&
            Number(newValue) > Number(endNum) - Number(startNum) + 1
          ) {
            setCountRed(
              "중복불가면 개수는 최대 시작번호,끝번호 차이+1 입니다."
            );
          } else {
            setCountRed("");
          }
          setCount(newValue);
        }}
      />
      <div style={{ color: "red" }}>{countRed}</div>
      {isDistinct && (
        <button
          onClick={() => {
            setIsDistinct(false);
          }}
        >
          중복불가
        </button>
      )}
      {!isDistinct && (
        <button
          onClick={() => {
            setIsDistinct(true);
          }}
        >
          중복허용
        </button>
      )}
      <button onClick={makeResult}>추출하기</button>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {arr.map((data, index) => (
          <div key={index}>
            <h1 style={{ padding: "10px" }}>{data}</h1>
          </div>
        ))}
      </div>
    </div>
  );
}
