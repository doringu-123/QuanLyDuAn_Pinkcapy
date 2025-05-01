import { Carousel } from "@mantine/carousel";
import { jobCategory } from "../Data/Data";
import { IconArrowRight, IconArrowLeft } from "@tabler/icons-react"; // Import icon mũi tên

const JobCategory = () => {
  return (
    <div className="mt-20 pb-5 bg-mine-shaft-900">
      <div className="text-4xl text-center font-semibold mb-5 text-white">
        Browse <span className="text-bright-sun-400">Job</span> Categories
      </div>
      <div className="text-lg mb-10 mx-auto text-center text-gray-300">
        Explore diverse job opportunities tailored to your skills. Start your career journey today!
      </div>

      {/* Carousel for job categories */}
      <Carousel
        slideSize="100%"
        slideGap="md"
        loop
        withControls
        withIndicators
        nextControlIcon={<IconArrowRight className="h-8 w-8 text-bright-sun-400" />}
        previousControlIcon={<IconArrowLeft className="h-8 w-8 text-bright-sun-400" />}
      >
        <Carousel.Slide>
          <div className="flex justify-center gap-8">
            {jobCategory.map((category, index) => (
              <div
                key={index}
                className="flex flex-col items-center w-64 gap-2 border border-bright-sun-400 rounded-xl p-4 hover:cursor-pointer hover:shadow-[0_0_5px_2px_black]"
              >
                {/* Icon container */}
                <div className="p-4 bg-bright-sun-300 rounded-full mb-4">
                  <img
                    className="h-12 w-12"
                    src={`/Category/${category.name.replace(/\s+/g, "")}.png`}
                    alt={category.name}
                  />
                </div>
                {/* Category name */}
                <div className="text-white text-xl font-semibold mb-2">
                  {category.name}
                </div>
                {/* Category description */}
                <div className="text-gray-400 text-sm mb-2 text-center">
                  {category.desc}
                </div>
                {/* Job count */}
                <div className="text-bright-sun-400 text-lg font-medium">
                  {category.jobs || "1k+"} new jobs posted
                </div>
              </div>
            ))}
          </div>
        </Carousel.Slide>
      </Carousel>
    </div>
  );
};

export default JobCategory;