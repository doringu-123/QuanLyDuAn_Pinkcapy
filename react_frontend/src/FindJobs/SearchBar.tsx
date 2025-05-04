import Multinput from "./Multinput";
import { dropdownData } from "../Data/JobsData";
import { RangeSlider } from "@mantine/core";
import { useState } from "react";

const SearchBar = () => {
  const [value, setValue] = useState<[number, number]>([20, 80]);

  return (
    <div className="flex justify-between">
      {dropdownData.map((item, index) => (
        <div key={index} className="w-1/5">
          <Multinput options={item.options} title={item.title} />
        </div>
      ))}
      <div className="w-1/5">
        <div className="flex justify-between mb-2">
          <div>Salary</div>
          <div>
            ${value[0]}k - ${value[1]}k
          </div>
        </div>
        <RangeSlider
          size="xs"
          value={value}
          onChange={setValue}
        />
      </div>
    </div>
  );
};

export default SearchBar;