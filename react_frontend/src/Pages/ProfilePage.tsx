import { Avatar, Button, TextInput, Textarea } from "@mantine/core";

const ProfilePage = () => {
  return (
    <div className="min-h-[100vh] bg-blue-100 font-['Poppins'] p-10">
      <div className="bg-white rounded-lg shadow-lg p-8 max-w-4xl mx-auto">
        <div className="flex items-center gap-6 mb-8">
          <Avatar size="xl" src="/avatar.png" alt="Profile Avatar" />
          <div>
            <h1 className="text-2xl font-semibold text-blue-600">Hồ sơ cá nhân</h1>
            <p className="text-gray-500">Cập nhật thông tin cá nhân của bạn</p>
          </div>
        </div>
        <div className="grid grid-cols-2 gap-6">
          <TextInput label="Họ và tên" placeholder="Nhập họ và tên" />
          <TextInput label="Email" placeholder="Nhập email" />
          <TextInput label="Số điện thoại" placeholder="Nhập số điện thoại" />
          <TextInput label="Địa chỉ" placeholder="Nhập địa chỉ" />
        </div>
        <div className="mt-6">
          <Textarea
            label="Giới thiệu bản thân"
            placeholder="Viết một đoạn ngắn về bạn"
            minRows={4}
          />
        </div>
        <div className="mt-8 flex justify-end">
          <Button className="bg-blue-500 hover:bg-blue-600 text-white">
            Lưu thay đổi
          </Button>
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;