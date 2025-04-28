const JobCategory = () => {
  return (
    <div className="mt-20 pb-5">
      <div className="text-4xl text-center font-semibold mb-3 text-mine-shaft-100">
        Browse <span className="text-bright-sun-400">Job</span> Category
      </div>
      <div className="text-lg mx-auto text-center">
        Explore diverse job opportunities tailored to your skills. Start your career journey today!
      </div>
      <div className="flex flex-col items-center w-64">
        <div className="p-2 bg-bright-sun-300 rounded-full">
          <img className="h-8 w-8" src="/Category/DigitalMarketing.png" alt="Digital Marketing" />
        </div>
        <div className="text-mine-shaft-100 text-xl font-semibold">Digital Marketing</div>
        <div className="text-sm text-center">
          Consectetur adipisicing elit. Sed, numquam.
        </div>
        <div className="text-bright-sun-300 text-lg">1k+ new jobs posted</div>
      </div>
    </div>
  );
};

export default JobCategory;