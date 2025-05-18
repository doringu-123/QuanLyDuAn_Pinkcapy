import { Button, TextInput, Textarea, Select } from "@mantine/core";

const PostJobPage = () => {
  return (
    <div className="min-h-[100vh] bg-blue-50 font-['Poppins'] p-10">
      <div className="bg-white rounded-lg shadow-lg p-8 max-w-4xl mx-auto">
        <h1 className="text-2xl font-semibold text-blue-600 mb-6">Đăng tin tuyển dụng</h1>
        <div className="grid grid-cols-2 gap-6">
          <TextInput label="Tên công việc" placeholder="Nhập tên công việc" />
          <TextInput label="Tên công ty" placeholder="Nhập tên công ty" />
          <TextInput label="Địa điểm" placeholder="Nhập địa điểm làm việc" />
          <Select
            label="Loại công việc"
            placeholder="Chọn loại công việc"
            data={["Full-Time", "Part-Time", "Freelance", "Internship"]}
          />
          <TextInput label="Mức lương (LPA)" placeholder="Nhập mức lương" />
          <Select
            label="Kinh nghiệm"
            placeholder="Chọn mức kinh nghiệm"
            data={["Entry Level", "Intermediate", "Expert"]}
          />
        </div>
        <div className="mt-6">
          <Textarea
            label="Mô tả công việc"
            placeholder="Nhập mô tả công việc"
            minRows={4}
          />
        </div>
        <div className="mt-8 flex justify-end">
          <Button className="bg-blue-500 hover:bg-blue-600 text-white">
            Đăng tin
          </Button>
        </div>
      </div>
    </div>
  );
};

export default PostJobPage;