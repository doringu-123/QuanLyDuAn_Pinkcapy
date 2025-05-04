import JobCard from "./JobCard";
import Sort from "./Sort";
import { jobList } from "../Data/JobsData";

const Jobs = () => {
  return (
    <div className="px-5">
      <div className="flex justify-between mb-4">
        <div className="text-2xl font-semibold">Recommended Jobs</div>
        <Sort />
      </div>

      <div className="mt-10 flex flex-wrap gap-5">
        {jobList.map((job, index) => (
          <JobCard
            key={index}
            jobTitle={job.jobTitle}
            company={job.company}
            applicants={job.applicants}
            experience={job.experience}
            jobType={job.jobType}
            location={job.location}
            package={job.package}
            postedDaysAgo={job.postedDaysAgo}
            description={job.description}
          />
        ))}
      </div>
    </div>
  );
};

export default Jobs;