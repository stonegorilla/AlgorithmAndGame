"use client";
import Link from "next/link";
import axios from "axios";
import port from "../../../public/port";

import React, { useState } from "react";
export default function Page() {
  const [num, setNum] = useState("");

  const [numError, setNumError] = useState("");
  const [fibonacciResult, setFibonacciResult] = useState("");

  const MAX_VALUE = 10000000;

  async function makeResult() {
    if (numError != "") {
      alert("올바른 값을 입력해주세요");
      return;
    }
    const startTime = Date.now();
    await axios
      .get(`${port}/calculation/fibonacci?num=${Number(num)}`)
      .then(function (response) {
        setFibonacciResult(response.data.result);
      })
      .catch(function (error) {});
    // let a0 = BigInt(0);
    // let a1 = BigInt(1);
    // for (let i = 2; i <= Number(num); i++) {
    //   let temp = a0;
    //   a0 = a1;
    //   a1 = a0 + temp;
    // }
    // setFibonacciResult(String(a1));
    const endTime = Date.now();
    console.log(endTime - startTime);
  }

  return (
    <div
      style={{
        padding: "30px",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
      }}
    >
      <h1>피보나치 수열</h1>
      <div>
        숫자를 적으세요 :{" "}
        <input
          value={num}
          onChange={(e) => {
            const newValue = e.target.value;

            if (!newValue.match(/^-?\d+$/)) {
              setNumError("정수를 입력해 주세요");
            } else if (Number(newValue) > MAX_VALUE) {
              setNumError("10000 이하의 숫자를 입력해 주세요");
            } else if (Number(newValue) < 0) {
              setNumError("0 이상의 숫자를 입력해 주세요");
            } else {
              setNumError("");
            }
            setNum(e.target.value);
          }}
        />
      </div>
      <div style={{ color: "red" }}>{numError}</div>

      <button onClick={makeResult}>입력</button>
      <div>
        <h1 style={{ display: "flex", flexWrap: "wrap", width: "100%" }}>
          {fibonacciResult}
        </h1>
      </div>
    </div>
  );
}
