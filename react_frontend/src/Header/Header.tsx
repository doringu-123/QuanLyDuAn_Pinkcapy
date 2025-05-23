import { Avatar } from '@mantine/core';
import { IconBell, IconBriefcaseFilled, IconSettings } from '@tabler/icons-react';
import NavLinks from './NavLink';
import { useLocation } from 'react-router-dom';
import ProfileMenu from './ProfileMenu';

const Header = () => {
    const location = useLocation();

    if (location.pathname === "/signup") return null;

    return (
        <div className="w-full bg-shakespeare-500 text-white h-28 flex justify-between">
            <div className="flex gap-3 items-center">
                <IconBriefcaseFilled className="h-10 w-10" stroke={1.25} />
                <div className="text-3xl font-semibold">TalentHub</div>
            </div>
            <NavLinks />
            <div className="flex gap-2 items-center">
                <ProfileMenu />
                <IconSettings />
                <IconBell />
            </div>
        </div>
    );
};

export default Header;