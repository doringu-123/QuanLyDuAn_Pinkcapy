const CertiCard = (props: any) => {
  return (
    <div className="flex justify-between items-center p-4 bg-white rounded-lg shadow mb-3">
      <div className="flex flex-col">
        <div className="font-semibold">{props.title}</div>
        <div className="text-sm text-mine-shaft-300">{props.organization}</div>
      </div>
      <div className="flex flex-col items-end">
        <div className="text-sm text-mine-shaft-300">Issued {props.issueDate}</div>
        <div className="text-sm text-mine-shaft-300">ID: {props.certificateId}</div>
      </div>
    </div>
  );
};

export default CertiCard;