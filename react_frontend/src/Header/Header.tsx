import { Avatar } from '@mantine/core';
import { IconBell, IconBriefcaseFilled, IconSettings } from '@tabler/icons-react';
import NavLinks from './NavLink';

const Header = () => {
    return (
        <div className="w-full bg-shakespeare-500 text-white h-28 flex justify-between">
            <div className="flex gap-3 items-center">
                <IconBriefcaseFilled className="h-10 w-10" stroke={1.25} />
                <div className="text-3xl font-semibold">TalentHub</div>
            </div>
            {/* Chỉ giữ lại NavLinks để tránh trùng lặp */}
            <NavLinks />
            <div className="flex gap-2 items-center">
                <div className="flex items-center">
                    <div>Thien Nguyen</div>
                    <Avatar src="avatar.png" alt="hehehuhu" />
                </div>
                <IconSettings />
                <IconBell />
            </div>
        </div>
    );
};

export default Header;