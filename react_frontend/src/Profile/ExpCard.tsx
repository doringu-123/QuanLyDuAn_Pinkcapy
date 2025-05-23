const ExpCard = (props: any) => {
  return (
    <div className="flex flex-col gap-2">
      <div className="flex gap-2 items-center">
        {/* Hiển thị logo công ty nếu có */}
        {props.logo && (
          <img
            src={props.logo}
            alt={props.company}
            className="w-8 h-8 object-contain rounded-md border border-gray-200 bg-gray-50"
          />
        )}
        <div className="flex flex-col">
          <div className="font-semibold">{props.company} &bull; {props.position}</div>
          <div className="text-sm text-mine-shaft-300">{props.duration}</div>
        </div>
      </div>
      <div className="text-sm text-mine-shaft-300 text-justify mt-1">
        {props.description}
      </div>
    </div>
  );
};

export default ExpCard;