import { IconSearch } from '@tabler/icons-react'; // Import biểu tượng tìm kiếm

const DreamJob = () => {
  return (
    <div className="flex items-center px-16 bg-white">
      {/* Phần bên trái */}
      <div className="flex flex-col w-[45%] gap-3">
        <div className="text-6xl font-bold text-sun-400 leading-tight">
          Tìm kiếm <span className="text-orange-500">công việc mơ ước</span> với chúng tôi
        </div>
        <div className="text-lg text-gray-600">
          Good life begins with a good company. Start exploring thousands of jobs in one place.
        </div>
        <div className="flex gap-3">
          <input
            className="bg-mine-shaft-900 border border-gray-400 rounded-lg p-2 text-white placeholder-gray-400"
            type="text"
            placeholder="Job Title (e.g., Software Engineer)"
          />
          <input
            className="bg-mine-shaft-900 border border-gray-400 rounded-lg p-2 text-white placeholder-gray-400"
            type="text"
            placeholder="Job Type (e.g., Fulltime)"
          />
          <button className="bg-bright-sun-400 text-black rounded-lg px-4 py-2 flex items-center justify-center">
            <IconSearch className="h-5 w-5" />
          </button>
          
        </div>
      </div>

      {/* Phần bên phải */}
      <div className="w-[55%] flex items-center justify-center">
        <div className="w-[30rem]">
          <img src="/newJob.jpeg" alt="Dream Job" className="rounded-lg shadow-lg" />
        </div>
      </div>
    </div>
  );
};

export default DreamJob;