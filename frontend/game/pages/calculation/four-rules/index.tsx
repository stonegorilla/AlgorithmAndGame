"use client";
import Link from "next/link";
import axios from "axios";
import React, { useState } from "react";
export default function Page() {
  const [result1, setResult1] = useState(0);
  const [result2, setResult2] = useState(0);
  const [finalResult, setFinalResult] = useState(new Array(5));
  const MAX_VALUE = 10000;

  function makeResult() {
    axios
      .get(
        `http://localhost:8080/calculation/basic?a=${Number(
          result1
        )}&b=${Number(result2)}`
      )
      .then(function (response) {
        setFinalResult((prev) => {
          const updateArray: any[] = [...prev];
          updateArray[0] = response.data.add;
          updateArray[1] = response.data.sub;
          updateArray[2] = response.data.mul;
          updateArray[3] = response.data.div;
          updateArray[4] = response.data.rem;
          return updateArray;
        });
      })
      .catch(function (error) {});
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
      <h1>여기는 사칙연산</h1>
      <div>
        a :{" "}
        <input
          type="number"
          value={result1}
          onChange={(e) => {
            const newValue = Number(e.target.value);
            if (newValue > MAX_VALUE) {
              setResult1(10000);
            } else if (newValue < -MAX_VALUE) {
              setResult1(-10000);
            } else {
              setResult1(Number(e.target.value));
            }
          }}
        />
      </div>
      <div>
        b :{" "}
        <input
          type="number"
          value={result2}
          onChange={(e) => {
            const newValue = Number(e.target.value);
            if (newValue > MAX_VALUE) {
              setResult2(10000);
            } else if (newValue < -MAX_VALUE) {
              setResult2(-10000);
            } else {
              setResult2(Number(e.target.value));
            }
          }}
        />
      </div>

      <button onClick={makeResult}>입력</button>
      <h1>{finalResult[0]}</h1>
      <h1>{finalResult[1]}</h1>
      <h1>{finalResult[2]}</h1>
      <h1>{finalResult[3]}</h1>
      <h1>{finalResult[4]}</h1>
    </div>
  );
}
