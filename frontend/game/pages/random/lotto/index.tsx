"use client";
import Link from "next/link";
import axios from "axios";
import React, { useState } from "react";
export default function Page() {
  const [startNum, setStartNum] = useState(0);
  const [endNum, setEndNum] = useState(0);
  const [count, setCount] = useState(1);
  const [isDistinct, setIsDistinct] = useState(false);
  return (
    <div
      style={{
        padding: "30px",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
      }}
    >
      <h1>로또번호 추출기</h1>
      {/* 숫자범위, 개수,중복여부 */}
      시작번호 :{" "}
      <input
        value={startNum}
        onChange={(e) => {
          const newValue = Number(e.target.value);
          if (newValue < 0) {
            setStartNum(0);
          } else if (newValue > endNum) {
            setStartNum(endNum);
          } else {
            setStartNum(newValue);
          }
        }}
      />
      끝번호 :{" "}
      <input
        value={endNum}
        onChange={(e) => {
          const newValue = Number(e.target.value);
          if (newValue < startNum) {
            setEndNum(startNum);
          } else if (newValue > 10000000) {
            setEndNum(10000000);
          } else {
            setEndNum(newValue);
          }
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
      <button>중복x</button>
      <button>추출하기</button>
    </div>
  );
}
