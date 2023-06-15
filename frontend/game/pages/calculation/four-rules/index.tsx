"use client";
import Link from "next/link";
import axios from "axios";
import React, { useState } from "react";
export default function Page() {
  const [result1, setResult1] = useState("");
  const [result2, setResult2] = useState("");
  const [finalResult, setFinalResult] = useState(new Array(5));
  const [result1Error, setResult1Error] = useState("");
  const [result2Error, setResult2Error] = useState("");

  const MAX_VALUE = 10000;

  function makeResult() {
    if (result1Error != "" && result2Error != "") {
      alert("올바른 값을 입력해주세요");
      return;
    }
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
          value={result1}
          onChange={(e) => {
            const newValue = e.target.value;

            if (!newValue.match(/^-?\d+$/)) {
              setResult1Error("정수를 입력해 주세요");
            }
            // else if (Number(newValue) > MAX_VALUE) {
            //   setResult1Error("10000 이하의 숫자를 입력해 주세요");
            // } else if (Number(newValue) < -MAX_VALUE) {
            //   setResult1Error("-10000 이상의 숫자를 입력해 주세요");
            // }
            else {
              setResult1Error("");
            }
            setResult1(e.target.value);
          }}
        />
      </div>
      <div style={{ color: "red" }}>{result1Error}</div>
      <div>
        b :{" "}
        <input
          value={result2}
          onChange={(e) => {
            const newValue = e.target.value;

            if (!newValue.match(/^-?\d+$/)) {
              setResult2Error("정수를 입력해 주세요");
            }
            // else if (Number(newValue) > MAX_VALUE) {
            //   setResult2Error("10000 이하의 숫자를 입력해 주세요");
            // } else if (Number(newValue) < -MAX_VALUE) {
            //   setResult2Error("-10000 이상의 숫자를 입력해 주세요");
            // }
            else {
              setResult2Error("");
            }
            setResult2(e.target.value);
          }}
        />
      </div>
      <div style={{ color: "red" }}>{result2Error}</div>

      <button onClick={makeResult}>입력</button>
      <h1>{finalResult[0]}</h1>
      <h1>{finalResult[1]}</h1>
      <h1>{finalResult[2]}</h1>
      <h1>{finalResult[3]}</h1>
      <h1>{finalResult[4]}</h1>
    </div>
  );
}
