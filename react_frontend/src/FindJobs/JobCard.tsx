import { IconBookmark, IconClockHour3 } from "@tabler/icons-react";
import { Text, Divider } from "@mantine/core";

const JobCard = (props: any) => {
  return (
    <div className="bg-mine-shaft-900 p-4 w-72 hover:shadow-md shadow-mine-shaft-600 !shadow-blue-500 rounded-lg transition-all duration-300 cursor-pointer">
      <div className="flex justify-between">
        <div className="flex gap-2 items-center">
          <div className="p-2 bg-mine-shaft-800 rounded-md">
            <img
              className="h-7"
              src={`/Icons/${props.company}`}
              alt={`${props.company} Logo`}
            />
          </div>
          <div>
            <div className="font-semibold">{props.jobTitle}</div>
            <div className="text-xs text-mine-shaft-300">
              {props.company} &#x2022; {props.applicants} Applicants
            </div>
          </div>
        </div>
        <IconBookmark />
      </div>
      <div className="flex gap-2 [&>div]:py-1 [&>div]:px-2 [&>div]:bg-mine-shaft-800 [&>div]:text-bright-sun-400 [&>div]:rounded-lg text-sm">
        <div>{props.experience}</div>
        <div>{props.jobType}</div>
        <div>{props.location}</div>
      </div>
      <Text lineClamp={3} className="!text-xs text-justify text-mine-shaft-300 mt-2">
        {props.description}
      </Text>
      <Divider size="xs" color="mineShaft.7" className="my-2" />
      <div className="flex justify-between">
        <div className="font-semibold text-mine-shaft-200">&#8377;{props.package}</div>
        <div className="flex gap-1 text-xs text-mine-shaft-400 items-center">
          <IconClockHour3 className="h-5 w-5" stroke={1.5} /> {props.postedDaysAgo} days ago
        </div>
      </div>
    </div>
  );
};

export default JobCard;