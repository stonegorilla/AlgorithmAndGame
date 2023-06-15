"use client";
import Link from "next/link";
import axios from "axios";
import React, { useState } from "react";
export default function Page() {
  const [startNum, setStartNum] = useState(0);
  const [endNum, setEndNum] = useState(0);
  const [count, setCount] = useState(1);
  const [isDistinct, setIsDistinct] = useState(true);
  const [arr, setArr] = useState([]);
  function makeResult() {
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
          const newValue = Number(e.target.value);
          setStartNum(newValue);
        }}
      />
      끝번호 :{" "}
      <input
        value={endNum}
        onChange={(e) => {
          const newValue = Number(e.target.value);
          setEndNum(newValue);
        }}
      />
      개수 :{" "}
      <input
        value={count}
        onChange={(e) => {
          const newValue = Number(e.target.value);
          if (newValue < 1) {
            setCount(1);
          } else if (newValue > 100) {
            setCount(100);
          } else {
            setCount(newValue);
          }
        }}
      />
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
